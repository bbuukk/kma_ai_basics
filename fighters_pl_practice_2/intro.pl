/*
male(albert). % a fact stating albert is a male
male(edward).

female(alice). % a fact stating alice is a female
female(victoria).

% parent(X,Y) - X is parent of Y
parent(albert,edward). % a fact: albert is parent of edward
parent(victoria,edward).
parent(alice,edward).

father(X,Y) :- % a rule: X is father of Y if X if a male parent of Y
            parent(X,Y), male(X). % body of above rule, can be on same line.

mother(X,Y) :- parent(X,Y), female(X). % a similar rule for X being mother of Y

/* 
    1. A fact/rule (statement) ends with `.` and white space ignored.
    2. read `:-` after rule head as "if" in other PL. Read comma in body as "and".
    3. Comment a line with `%` or use `/* */` for multi-line comments.
*/
*/



% simpsons

male(homer).
male(bart).
male(abe).

female(marge).
female(lisa).
female(maggie).
female(mona).

parent(homer, bart).
parent(homer, lisa).
parent(homer, maggie).
parent(marge, bart).
parent(marge, lisa).
parent(marge, maggie).
parent(abe, homer).
parent(mona, homer).



mother(X, Y) :- parent(X, Y), female(X).
father(X, Y) :- parent(X, Y), male(X).
son(X, Y) :- parent(Y, X), male(X).
daughter(X, Y) :- parent(Y, X), female(X).

grandparent(X, Y) :- parent(X, Z), parent(Z, Y).


% max 
myFilter([], R, R). % end
myFilter([X|Xs], WK, R):- X >  WK, myFilter(Xs, X, R). % WK is Carry about
myFilter([X|Xs], WK, R):- X =< WK, myFilter(Xs, WK, R).

myFilter([X|Xs], R):- myFilter(Xs, X, R). % start

% fib seq
fib(0, 1) :- !.
fib(1, 1) :- !.
fib(N, F) :-
        N > 1,
        N1 is N-1,
        N2 is N-2,
        fib(N1, F1),
        fib(N2, F2),
        F is F1+F2.
