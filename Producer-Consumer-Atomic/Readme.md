Bad example of Producer-Consumer pattern using atomic boolean flag. Producer ends up updating
the value twice before the consumer can output it and vice versa. It's important to notice 
that using atomic classes is not enough to guarantee order between producer-consumer.

Solution: Wait-notify semaphore. Basically same example like the previous implementation, but
with atomic flag (which presumably is faster than normal volatile boolean).