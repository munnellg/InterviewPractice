# Node

I'm not sure if my solution to this one is correct. The given solution in CtCI takes a different tack to me, but I think you could argue the case for what I've done here.

I think the crux of the argument lies in whether or not a stack *must* reside in contiguous memory blocks. I would argue it doesn't, even though logically this is where a stack comes from. At Java's level of abstraction, we don't really care where each node resides. What matters is the functionality -- push, pop etc. The access limitations of a stack in Java are imposed by software constraints, not hardware constraints. Arguably the same is true for C, although because we can interact with raw pointers in C, perhaps it would be important for stack nodes to be contiguous.

With this in mind, my perspective when tackling this problem is that it is a resource allocation problem, rather than just a fudge to shove three stacks in one array. We have a buffer which represents the amount of available memory that may be used for a stack. A memory manager hands out blocks in the buffer to different stacks as they request them. The blocks of each stack are interlaced, but the blocks store pointers so we can still push/pop while also allocating/deallocating with the memory manager.

This makes much more sense in C than Java, though. In C we're doing some memory management and avoiding dynamic memory allocation by having a buffer which allocates memory to stacks. In Java, we're really just keeping a list of references to stack nodes that exist.

If you've read this and have thoughts, I'm happy to hear them.