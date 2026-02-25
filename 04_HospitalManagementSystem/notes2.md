# JOIN-TABLES AND MAPPING

## Foreign Key
    - Whenever we add the refernece of ANY other Entity to some Entity, the latter's table gets a new coloumn storing the PRIMARY KEY of the former

    - This connection between two Entities MUST be defined according to their Mapping: OneToOne, OneToMany etc. We use annotations like @OneToMany, @OneToOne etc. to do the same.

## Owner Side
    - This Entity side has a coloumn for the direct reference of the ref-Entity. This Enityt's table directly stores the id/primary-key of the referenced data
    - We use @JoinColomn to define that current Entity is the Owner Side
    
    - Ex: For a Paitent and Appointments connection:
    1. 1 Paitent can have many Appointments
    2. 1 Appointment can have ONLY one Paitent.
    So this relationship is a ManyToOne on Appointment side and OneToMany on the Paitent side
    3. Here we define Appointment as the Owner Side because it cannot survive withoout a Paitent.

## Inverse Side
    - This entity has NO COLOUMN defined for the reference of the 2nd-party entity. This STILL has a reference for the field which defines it in the Owner Side table.
    - Fetching the Inverse side and printing the Object gives NO DATA for the Owner's side because this table DOES NOT store any data for owner side.
    - We can still use functions to directly fetch the Owner's side data as the schema contains a mapping field reffering to the FK field in the Owner side.

    Ex: Since Appointment is defined as the Owner Side, the paitent table does not store any AppointmentList in its table, BUT we can directly fetch the Paitents appts. (using 1 extra db call) by the mapped-by field in the Entity class.

Note: If there is a OneToMany relationship 
    - Owner side the relationship is One to Many
    - Inverse side the relationship is Many to one