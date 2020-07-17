# Chess - Low level system design

## Problem Statements
[Problem Statement](problem-statement.md)

## Further enhancements
* Implement checkmate feature.
* Write more unit tests.
* Support special move of pawn where it can go diagonal when it kills.
* At many places, we are evaluating conditions like:
  * **OR Operation**: We are allowed to do something if any condition out of given conditions fulfill. 
  * **And Operation**: We are allowed to do something if all conditions fulfill.  
  Try to improve the design for this.
* Add history of moves for each player.

