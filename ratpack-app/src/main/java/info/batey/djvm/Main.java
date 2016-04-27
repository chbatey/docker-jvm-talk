package info.batey.djvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.exec.Promise;
import ratpack.http.client.HttpClient;
import ratpack.server.RatpackServer;

import java.net.URI;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) throws Exception {

        Db db = new Db();
        RatpackServer.start(server -> server
                .registryOf(rs -> rs.add(db))
                .handlers(chain -> chain
                        .all(ctx -> {
                            LOGGER.info("All");
                            ctx.next();
                        })
                        .get("callout", ctx -> {
                            Db database = ctx.get(Db.class);

                            Promise<String> response = ctx.get(HttpClient.class)
                                    .get(new URI("http://localhost:7070/name"))
                                    .map(r -> r.getBody().getText());

                            Promise<String> withDb = response.flatMap(database::getRecord);

                            ctx.render(withDb);
                        })
                        .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!"))
                ));

    }
}
