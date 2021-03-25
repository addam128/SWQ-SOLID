# Open/Closed Principle

Due to the fact that one class was dealing with all the persistence types, and more so in the way it did it,
to add JSON persistence, I would have had to change:

* the Persistence classes constructor -> all calls
* add new path attribute 
* add a new enum type
* change the persist method -> all calls would need to be repeated with JSON
* work with lots of switch statements, persistence types passed as arguments, etc.

What i did was:
* delete the enum
* make classes for each persistence type, governing their own methods fully
* the master persistence is now just a holder of self-governing persistence classes
* the master classes persist method just calls the small persist classes persist methods
* this option is good when persistence is done so that we always use every type of it
* when we want to call different persistence types separately, the solution is described abelow

To add a new persistence:

* implement the class doing the job
* cretate that class in main and use it
* the use of a master persistence class is not needed
* the master class could be different, it could have add methods for all persistence types, have them as attributes, and then implement for all persistence types a persist\<JSon, Xml, Csv\> method to call that one only. This way adding a new persistence would require adding 2 methjods and an attribute to the MasterPersistence class, but they would be usable separately

