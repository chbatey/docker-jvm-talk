package info.batey.djvm;

import ratpack.exec.Promise;


public class Db {
    Promise<String> getRecord(String name) {
        return Promise.value("A DB record:" + name);
    }
}
