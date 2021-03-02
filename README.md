# University-Time-Table-Generator
**University Time Table Generator using Artificial Intelligence**

**Main Design:**  
Courses are the variables .Domain value is one object called CourseDomain. The course domain consists of Timeslot, Instructor and Room. Every course variable is connected to very other variable .There are 3 separate classes called Timeslot, Instructor and Room. The class ConstraintSatisfactionCheck has the main backtracking algorithm. The heuristics MRV and MCV are implemented in Selection class. The heuristic LCV is implemented in ConstraintSatisfactionCheck class .Arc consistency and Forward checking is in one class called Arc Consistency.

**Minimum remaining values:**  
We take in the   list of variables which have not been assigned any value and then we check the number of domain values left in each domain, then we add the variables with the minimum remaining values to a List .Finally, we return the list of variables with minimum remaining values. 

**Most constrained variable:**  
We take a MRV list of variables as the input, and then we check the number of neighbors of each variable (course) in MRV list. The neighbors signify the number of edges from each variable. Since in this problem every variable is connected to every other variable, every variable is equally constrained.

**Least Constraining variable:**  
We take in the one variable we got from MRV list, and then we check the effect of selecting a value from the variable’s domain on the neighbor’s domain. We do this by checking the sum of values left in neighbor’s domain each time a value is selected. This would give a final array of sum of effect of selecting a value on the neighbors, then we select a value which is least constraining on the neighboring variables. This value  gives more values to all the neighbors or in other words least constraining value.

**Forward Checking:**  
This heuristics is applied after a value is assigned to a variable. The function name is fccheck ().It takes the variable and the assigned value as the parameter. It then gets the list of neighbors and removes this value from neighbor’s domain if the value is present in its domain. It then returns the CSP object with new domains of all the variables.

**Arc Consistency & Propagation:**  
This heuristics is applied as a propagation step after a value is assigned to variable. A queue is used to keep track of the arcs that need to be checked for inconsistency. Each arc is stored in a queue as a tuple (two values) list. Each arc is then checked for inconsistency, if any value needs to deleted from the domain of say X ,then every arc (Y,X) pointing to X must be inserted into the queue for checking. Finally, it returns the CSP object with new domain values for the variables.

**Reference Materials**  
* Book: Artificial Intelligence: A Modern Approach by Stuart Russell and Peter Norvig  
* Book Website: http://aima.cs.berkeley.edu/  
* Instructor : Professor Shekhar Pradhan from Marist College (https://www.linkedin.com/in/shekhar-pradhan-55412b11/)
