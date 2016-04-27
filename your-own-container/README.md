## Namespaces

### PID

Isolate a process tree. Making the root PID 1.

TODO: PS from host, go into a container and PS.

### MNT

Have a process tree have its own mount table. Including a different filesystem
that could have a different operating system on.

### NET

Have a process have its own network stack. 

TOOD: Examples of how this works with Rocket and Docker

### UTS

Give a process its own view of the machine's hostname.

### IPC

Inter process communication.

TODO: Research

### User

Allows mapping of users in the container to different users on the host. Meaning
that inside the container it can appear as root but it is actually mapped to a
non root user on the host.

### User

Allows mapping of users in the container to different users on the host. Meaning
that inside the container it can appear as root but it is actually mapped to a
non root user on the host.

## CGroups

Reosource allocation

## Layered file systems

Effiecent way to copy and shop a containers file system.

## Stuff

