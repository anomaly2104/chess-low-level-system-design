# Chess - Low level system design ![Build status](https://travis-ci.org/anomaly2104/chess-low-level-system-design.svg?branch=master)

## Video Explanation
[https://youtu.be/RVHNcng0oF0](https://youtu.be/RVHNcng0oF0)

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
* Add support for casteling move.
* Can we remove putting currentCell in Piece? How about introducing something like position?
    * A piece will have a position and you can always get the cell back from board using this position.

