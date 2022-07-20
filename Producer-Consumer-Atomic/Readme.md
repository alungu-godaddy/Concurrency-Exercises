Bad example of Producer-Consumer pattern using atomic boolean flag. Producer ends up updating
the value twice before the consumer can output it and vice versa. It's important to notice 
that using atomic classes is not enough to guarantee order between producer-consumer.

Note: This may be because the CPU compare and swap only guarantees that two threads do not access the
boolean flag at the same time, but after one updates it and the other takes notice, the latter
may work with the integer before the first actually updates it.

Solution: Wait-notify semaphore. Basically same example like the previous implementation, but
with atomic flag (which presumably is faster than normal volatile boolean).