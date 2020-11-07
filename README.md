# Implementing-Different-Set-Operations
CS211: Mathematics for Computer Science Programming Assignment 1
Problem statement:

 In this program we mainly implemented 3 operations : 
• Union of two sets :
Gets the union of any two sets that the user choose from the subsets of the universal set.
• Intersection of two sets : 
Gets the Intersection between any two sets that the user choose from the subsets of the universal set.
• Complement of a set :
Gets the Complement of any set that the user choose from the subsets of the universal set .

And implemented an interface called “ISet” to facilitate our work and implemented a class that we called “setAssignmentApp”  and in which we implemented our own linked list data structure .



Used data structures: 

1)	We used the idea of the linked list to make our program dynamic so that it can store any number of sets and then start the operations on that sets.
so We implemented our own linked list data structure class   which we called “setAssignmentApp” and used it .
2)	We used arrays also to put the elements of each set inside.

Assumptions:
-	We assume the Definition of sets as it can not has duplicated elements and the Arrange the elements is not significant and that will affect us on the algorithms we use as shown below in the part of algorithms.
-	We also considered that the user might enter the set in a wrong way and he also might enter one of the sets is not a subset of the universal set so we handled all that problems that the user might commit. 
-	There is not other influential special assumption.

Algorithms:
-	We mainly dependent on some simple algorithms to do the Required operations but that has a reason for example we didn’t arrange the sets to reduce the time of the operations union or intersection to give the user an intuition that the set doesn’t need to be arranged.
-	We made some suboperations to get rid of the duplication and to read the input right from the user.
-	As I said We used the idea of the double linked list to give the application the free to be a dynamic one and to read any number of sets as the user want.

