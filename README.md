GemFire Cache Listener Feature

Gemfire Cache Listeners are registered with a region to handle region events such as entries being created, updated, destroyed, etc. A Cache Listener can be any bean that implements the com.gemstone.gemfire.cache.CacheListener interface. A region may have multiple listeners. Cache Listeners is important feature to observe data events at cluster-wide.

The methods of Cache Listener Interface :

- afterCreate(EntryEvent event) : Handles the event of new key being added to a region.
- afterDestroy(EntryEvent event) : Handles the event of an entry being destroyed.
- afterInvalidate(EntryEvent event) : Handles the event of an entry’s value being invalidated.
- afterRegionClear(RegionEvent event) : Handles the event of a region being cleared.
- afterRegionCreate(RegionEvent event) : Handles the event of a region being created.
- afterRegionDestroy(RegionEvent event) : Handles the event of a region being destroyed.
- afterRegionInvalidate(RegionEvent event) : Handles the event of a region being invalidated.
- afterRegionLive(RegionEvent event) : Handles the event of a region being live after receiving the marker from the server.
- afterUpdate(EntryEvent event) : Handles the event of an entry’s value being modified in a region.
- close() : Called when the region containing this callback is closed or destroyed, when the cache is closed, or when a callback is removed from a region using an AttributesMutator.

Used Technologies : JDK 1.7.0_40, Spring 3.2.3, SpringData-GemFire 1.3.0, GemFire 7.0 and Maven 3.0.4