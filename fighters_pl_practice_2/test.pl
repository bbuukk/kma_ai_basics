population(poland, 100).
population(ukraine, 110).
population(japan, 20).
population(usa, 90).

area(poland, 10).
area(ukraine, 11).
area(usa, 12).
area(japan, 2).

density(X,Y) :- population(X, Pop), area(X, Ar), Y is Pop/Ar.
