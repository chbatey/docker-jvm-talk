# Add Running a JVM in Docker, a good idea?

## Intro

This is a set of resources for understanding the complexities of running your JVM based application inside a
linux container, specifically Docker.
 
I'm doing a talk at the following conferences based on this material:
* Geecon 2016
* Devoxx UK 2016
* Devoxx Poland 2016

### Motivation

Why do we want to run our application inside containers?

* Multi tenancy
* Consistent deployment format across technology stacks
* Access to orchestration tools:
  * Kubernetes
  * Marathon on Mesos
* Using docker for other purposes: CI, dev dependencies

### Deployment options

* Traditional JEE/servelet container: WebSphere, Tomcat running on bare metal
* Executable jars with embedded Jetty running on bare metal
* A traditional container inside Docker? Why?
* Executable jar inside linux container - the sweet spot


### Cost savings

// TODO: Show number of servers for single vs VMs vs Kubernetes

## What

The best way to work with Docker is to learn a small amount about the underlying 
kernel features.

### Namespaces

Containers are built on top of Linux namespaces. Giving processes their own PID
namespace, mounts 

#### PID

TODO: 
* Demo PS inside and outside of the container.

#### Mount

TODO: 
* Show mounts inside and outside of a container. Show outside where the ones
inside map to.

#### Layered file systems

#### Users

TODO:
* Show uids inside and outside of the container.

### CGroups

In addition to namepsaces running containers are restricted via CGroups to the
amount of memory and CPU they use.

TODO: 
* Show a container with `systemd-cfls` then `systemd-cgtop` then put some
load and how that cgroup grow.

#### Docker access to CGroups

TODO: 
* Show options that can be passed to Docker run vs settings on cgroups.

* `memory`
* `memory--swap`
* `memory-soft-limit`
* `oom-kill-disable` (Show a java process with this on and not on)

* `cpu-shares`
* `cpuset-cpu`
* `cpu-mems` (for NUMA)

TODO: Show kubernetes docs about squashable resources


## Tools>

Top
Htop
Free
// Cotnainer breakdown
systemd-{cgtop, cgls}
// See namespaces for a process

CAdvisor

## Examples

Scenario: to get 1000 TPS for a container.

The logic inside the app containers one HTTP call and one Database call.

Goal is to make our container as small as possible.

Areas to investigate:
* Memory usage
* Tuning threads

TODO
* Count number of threads

### Thread per request

A lot of Java web frameworks, Servlets included, use the thread per request execution model.

// TODO Picture of a pool of threads

The popular Jetty servlet container is one such library. Dropwizard is a framework
that brings together Jersey with a few other popular libraries.

#### Dropwizard

### Thread per core

#### Ratpack example

#### Akka example (Optional)

### Demos

* OOM kill a process with JVM options
  * dmesg
  * docker logs
  * docker restart



TODO:
* Get CAdvisor on laptop
* Bootstrap all examples + download dependencies
* Compare various java base images
* Add logback to ratpack
