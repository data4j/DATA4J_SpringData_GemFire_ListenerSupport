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

Cache Listeners can be configured as the following :

1- Gemfire cache configuration xml file :

<region name="userRegion">
   <region-attributes scope="distributed-no-ack" data-policy="replicate">
      <cache-listener>
         <class-name>org.data4j.listener.UserCacheListener</class-name>  
      </cache-listener>
   </region-attributes>
</region>

2- Spring Data Gemfire Project helps the developers for easier integration. Listeners can be defined via the following configuration :

<gfe:replicated-region id="Customer">
   <gfe:cache-listener>
      <bean class="org.data4j.listener.TestCacheListener"/>
   </gfe:cache-listener>
</gfe:replicated-region>

In this article, only UserCacheListener has been configured for userRegion. However, A region may have multiple listeners via the following configuration :

<gfe:replicated-region id="region-with-listeners">
    <gfe:cache-listener>
        <!-- nested cache listener reference -->
        <ref bean="first-listener"/>
        
        <!-- nested cache listener declaration -->
        <bean class="org.data4j.listener.SecondTestCacheListener"/>
    </gfe:cache-listener>
    
    <bean id="first-listener" class="org.data4j.listener.FirstTestCacheListener"/>
 </gfe:replicated-region>
 
This article shows how to enable GemFire Cache Listener Feature. Let’ s look at the details.

Used Technologies : JDK 1.7.0_40, Spring 3.2.3, SpringData-GemFire 1.3.0, GemFire 7.0 and Maven 3.0.4