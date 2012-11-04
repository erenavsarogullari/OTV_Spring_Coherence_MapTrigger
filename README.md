Coherence Event Processing by using Map Trigger Feature

This project shows how to process Coherence events by using Map Triggers. Basically, OTV_Coherence is suggested to look over basic configuration and implementation of Oracle Coherence API.

Map Triggers are one of the most important features of Oracle Coherence to provide a highly customized cache management system. MapTrigger represents a functional agent that allows to validate, reject or modify mutating operations against an underlying map. Also, they can prevent invalid transactions, enforce security, provide event logging and auditing, and gather statistics on data modifications.

For example, we have code that is working with a NamedCache, and we want to change an entry’s behavior or contents before the entry is inserted into the map. This change can be made without modifying all the existing code by enabling a map trigger.

There are two ways to add Map Triggers feature to application :

1) A MapTriggerListener can be used to register a MapTrigger with a Named Cache
2) The class-factory mechanism can be used in the coherence-cache-config.xml configuration file

In the following sample application, MapTrigger functionality is implemented by following the first way. A new cluster called OTV, is created and User bean is distributed by user-map NamedCache object used among two members of the cluster.

Used Technologies : JDK 1.6.0_35, Spring 3.1.2, Coherence 3.7.1 and Maven 3.0.2.