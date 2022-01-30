# ozan-sarıbaloğlu-n11-talenthub-bootcamp-graduation-project

-------- Explanation of the project ---------------

Firstly, I've created two entities. One of them is "Member" entity. Second one is the "CreditApplication" entity.

Then I've created the Base Entity interface, because I want to avoid duplicating methods that is used so frequently. 

That's why, I implemented this interface within entity classes.

-------- Annotations ------------------------------

Also, I've used some annotations. For exp, @NoArgsConstructor creates a blank constructor and @AllArgsConstructor creates a constructor which includes all fields as parameters.

I've used @JsonIgnoreProperties({"hibernateLazyInitializer"}) because "fetch = FetchType.LAZY" in @ManyToOne annotation causes error in hibernate initializing.

@Data annotation creates all getter and setters with public mode. Also, I've used @Entity annotation to identify the class as an entity.

-------- Entity Service Classes -------------

Then, I've created EntityService classes of these entities. I've also extended this class to BaseEntityService class.

This BaseEntityService class is abstract and extends to JpaRepository. Also, some common methods are called in BaseEntityService.

For these entity services, I've created methods that cannot be called by Jpa repository. Other methods are not also required to be created in entity service classes.

-------- Service Classes --------------------

Let's continue with service classes. In CreditApplicationService class, I've used findAll, update, create, isExistPreviousRecord, findByMemberIdAndByBirthdate, calculateCreditLimit and calculateCreditResult methods.

-------- CreditApplication Service FindAll method ---------------------

In findAll, I've called findAll method automatically from JpaRepository using Base Entity Service.

I've converted it to Dto object and then I've returned list values.

-------- CreditApplication Service Update and Create methods --------------

In update and create, I've called save method automatically from JpaRepository using Base Entity Service.

However, I've made some arrangements in create method unlike update method.

I've checked whether there exists previous records of the selected member or not. If the member has previous records, then method throws an exception. Because a member should not apply continuously for credits.

After that, I've converted to Dto file then I've called calculation methods and assign them to variables.

Then, I've created an empty CreditApplication object. Then, I've applied set operations for every fields. After these processes, I've called save method in create method.

-------- CreditApplication Service IsExistPreviousRecord method ---------------

In this method, I've checked whether the selected member has previous records or not.

-------- CreditApplication Service FindByMemberIdAndByBirthdate method -------------

In this method, I've used two parameters which are personal number and birthdate.

In the beginning, I've checked whether the selected member's birthdate is matched with the birthdate parameter or not. If these details are not matched, then the method throws an exception.

After that, I've called "findByPersonalNumberAndByBirthDate" method from entity service class. Also, entity service calls the method with the same name from CreditApplicationRepositories interface.

-------- CreditApplication Service CalculateCreditLimit method -----------------------

In this method, I've calculated the credit limit according to the selected member's credit score that is called from CreditScore service class.

I've used the member class object for the parameter. I've gotten the monthly income info and deposit amount info to help the calculation.

Monthly income, deposit amount and credit score are required to calculate the credit limit.

Then, I apply if-else conditions because in some range of credit score, the credit limit calculation technique changes. In some range, deposit amount info also is included for the calculation.

-------- CreditApplication Service CalculateCreditResult method -------------------------

In this method, I've used the member type object for the parameter again.

I've used credit score info and monthly income info of the selected member to calculate the credit result type. In this method, deposit amount is not required.

Then, I've applied the same if-else conditions in the same range of credit score. I calculated the credit result whether the result is APPLIED or DENIED.

-------- CreditScore Service Class ----------------------------

In this service class, I only calculate the selected member's credit score according to the member's monthly income info.

I've used the member object type for the parameter again. Then, I've used the selected member's monthly income. Then, I calculated the credit score as the 8 percent of the monthly income of the selected member.

-------- Member Service Class ---------------------------------

In this service class, I've created all methods about member settings. I've used save, findAll, findById, delete, findMemberById, findByPersonalNumber and findMemberByPersonalNumber methods.

-------- Member Save method -----------------------------------------

In save method, I've called the save method from Jpa Repositories. If any new id exists, new record is added to database. Otherwise, the same member is updated.

-------- Member findAll method --------------------------------------

In findAll method, I've called the findAll method from Jpa Repositories automatically unlike creating a new method within the Member Repositories interface seperately.

Here, a member list fills all members of the database. After converting member list into memberDto list, method returns the list with members.

-------- Member findById method --------------------------------------

In this method, I've used a long type parameter for id. This parameter is used in findMemberById method. 

This method returns member who its id info is equal to the parameter. As the last step, this method returns a memberDto object type.

-------- Member delete method ----------------------------------------

Here, I've called the findMemberById method again. Delete method has a long type parameter. This parameter value is used for findMemberById method. 

Then, I've gotten the member according to the parameter value. After that, I've called the delete method from Jpa repositories automatically. 

Then, I've used the member as the parameter of this Jpa delete method. As the last step, the selected member is deleted.

-------- Member findMemberById method ---------------------------------

This method is used for finding a member record using a long type id value.

This parameter is used in findById method. This method is called from JpaRepositories and assigned to optional type variable.

If this optional variable is filled a value, then I've assigned this value into a member type variable. Otherwise, this method throws an exception.

This method is private, because this method should not be reachable from other classes. Finding a member with a specific value should be used in only the same class.

-------- Member findByPersonalNumber -----------------------------------

In this method, I've used a string type parameter for personal number. This parameter is used in findMemberByPersonalNumber method. 

This method returns member who its personal number info is equal to the parameter. As the last step, this method returns a memberDto object type.

-------- Member findMemberByPersonalNumber method ----------------------

This method is used for finding a member record using a string type personal number value.

This parameter is used in findByPersonalNumber method. This method is called from member entity service class and assigned to optional type variable.

If this optional variable is filled a value, then I've assigned this value into a member type variable. Otherwise, this method throws an exception.

This method is private, because this method should not be reachable from other classes. Finding a member with a specific value should be used in only the same class.

-------- EnumCreditResultType enumaration ------------------------------

Here, I've created an enumaration to record credit result types. These are called "APPROVED" and "DENIED" respectively.

Then, I've created a string variable. After that, I've created the getter and the setter for this enum. Lastly, I've used overriding to explain the value of enum.

-------- Mapper interfaces ----------------------------------------------

In these interfaces, I've used @Mapper annotation to identify these interfaces as mappers. 

Mapper interfaces apply mapping process. This mapping process enables us to make the converting. When we make converting, two classes should know which fields are matched. Otherwise, some values might be identified as null.

-------- CreditApplication and Member mapper interfaces -----------------------------

Here, I've used @Mapping annotation for converting and mapping. I've used target and source. This means that the source value is converted into the target value.

In the after mapping, if the long type value is null, then we set the member type value as null. Because different type variables might cause some problems in mapping process.

-------- Credit Application Repositories and Member Repositories interfaces ----------------------------------

These interfaces uses @Repository annotation to define these interface as a repository.

These interfaces both extend JpaRepository. For this, we need to define the related entity file as the first parameter and then we need to define the type of id as the second parameter into the JpaRepository in extending.

I've also used @Query annotation to get the record that I wanna show in the specified method because using only JpaRepositores does not work.

-------- Controller Classes -----------------------------------------------------------------------

I've used @CrossOrigin annotation. By default, this annotation allows all origins, all headers, and the HTTP methods specified in the @RequestMapping annotation.

I've used @RestController annotation. This annotation provides restful support for the controller.

I've also used @RequestMapping annotation to identify the address of the controller. This annotation's parameter is used after localhost web address.

@PostMapping applies posting process. @GetMapping applies getting process. Also these annotations identify which link address should be used unlike other controller methods.

@PathVariable annotation requires a standard variable but @RequestBody requires a long body values. All controller methods return ResponseEntity. All controller methods call service methods.

--------- Dto Classes ---------------------------------------------------------------------

Dto is meant "Data Transfer Object". Dto classes are meant to copy the entity classes. Because using directly entity variables or values might be risky. Transferring data values into another objects is more valuable to use.

A Data Transfer Object is an object that is used to encapsulate data, and send it from one subsystem of an application to another.

