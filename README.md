ReamsnyderGiftExchangePairer
============================

A simple Java app to create Reamsnyder Christmas gift exchange pairs

What? Why?
----------

Basically, this application takes some set of people (here, Reamsnyders) and matches them up, with the following criteria:

* Couples should not be matched to each other
* Everyone should be matched to someone else

How?
----

The matching algorithm is done heuristically, which is my way of saying lazily. I didn't do some sort of graph traversal algorithm before or after randomly assigning people (or assign them more intelligently), so it'll loop for a while (in computer time) and die if it detects that it's created a nonsensical set of pairings.

Bugs and Design Considerations
------------------------------

Ordinarily, these kinds of failures seem to occur when we get a graph cycle of nodes that are unpairable as they're partners.

It (the algorithm) also implicitly assumes an even number of people, as in, all couples. (Sorry, single folks. Sad panda, I know.)

But look, it's unit tested!
