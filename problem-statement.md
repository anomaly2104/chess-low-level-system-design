### Problem Statements: Chess LLD
We have to design simple chess game. Chess is actually a very popular game. You can read more about it online on wikipedia or on some other places.
 
#### Entities
If you have already played it already then you might already know this. But to ensure that we all are on the same page, I am defining some here:
* Board: Board is the one entity represents an actual board on which which you play this game.
* Cell: A board consists of a grid of cells.
* Player: Someone who is actually playing right.
* Piece: There are various types of pieces as explained below.

#### Pieces and their moves:
* King: Key entity in chess. If your king is killed then you lose. Its also called checkmate.
* Queen: It can move any number of steps in a single move and in any direction.
* Rook: It only moves in horizontal and vertical direction but can move any number of steps in single move.
* Bishop: It only moves in diagonal direction but can move any number of steps in single move.
* Knight: It makes L shaped moves. Check online for more details about it.
* Pawn: It can move 1 step forward vertically. If it is its first turn, then it can also choose to make 2 steps in single move.  
Note: All pieces except Knight cannot jump any other piece. Knight can jump over other pieces. 

## Expectations
* Code should be functionally correct.
* Code should be modular and readable. Clean and professional level code.
* Code should be extesible and scalable. Means it should be able to accomodate new requirements with minimal changes.
* Code should have good OOPs design.
