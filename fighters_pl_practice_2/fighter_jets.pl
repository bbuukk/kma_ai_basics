
fighter(f15Eagle). 
fighter(f15EStrikeEagle).
fighter(f15J).

fighter(f16FightingFalcon).
fighter(f16XL).
fighter(f2).

fighter(x35JSF).
fighter(f35LightningII).

fighter(spitfire).
fighter(spiteful).
fighter(seafung).
fighter(attacker).
fighter(swift).

introIn(f15Eagle, 1945).
introIn(spitfire, 1938).
introIn(f2, 1972).
introIn(swift, 1948 ).
introIn(f16XL, 1982).
introIn(f16FightingFalcon, 1973).

% dogfight is an aerial battle between fighter aircraft conducted at close range
% cas abr. for close air support
% sead abr. for suppression of Enemy Air Defenses

role(f35LightningII, dogfight). 
role(f35LightningII, cas).
role(f35LightningII, bomber). 
role(f35LightningII, spy). 
role(f35LightningII, electronicWarfare). 
role(f35LightningII, sead).

role(test, dogfight).
role(test, bomber). 
role(test, spy). 
role(test, cas). 

role(spitfire, dogfight).
role(spitfire, spy). 
role(spitfire, bomber). 

dev_from(f15EStrikeEagle, test).
dev_from(f15J, test).

dev_from(f16XL,f16FightingFalcon).
dev_from(f2, f16FightingFalcon).

dev_from(f35LightningII,x35JSF).

dev_from(spiteful, spitfire).
dev_from(seafang, spitfire).
dev_from(attacker, spiteful).
dev_from(swift, attacker).
dev_from(supermarine545, swift).

generation(first, 1940, 1950).
generation(second, 1955, 1960).
generation(third, 1960, 1970).
generation(fourth, 1970, 1985).
generation(fifth, 1990, 2000).
generation(sixth, 2000, 2029).

%find variation of aircraft(jet)
var_of(X,Y) :- dev_from(X,Z), dev_from(Y,Z), not(Y == X).

lightJet(X) :- role(X, dogfight), role(X, spy), role(X, electronicWarfare).
heavyJet(X) :- role(X, bomber), role(X, electronicWarfare), role(X, sead).
interceptorJet(X) :- role(X, spy), role(X, electronicWarfare), role(X, sead).
mrca(X) :- % multiporpose fighter
    role(X, dogfight),
     role(X, bomber),
      role(X, spy),
       role(X, sead),
        role(X, bomber),
         role(X, cas),
          role(X, electronicWarfare). 


%find origin of modified fighter jet
origin(X, X) :- not(dev_from(X, Z)), fighter(Z), !. % rewind
origin(X, R) :- dev_from(X, Y), origin(Y, R).

%find last modifications of fighter jet
last_mod(X, X) :- not(dev_from(Z, X)), fighter(Z), !. % rewind
last_mod(X, R) :- dev_from(Y, X), last_mod(Y, R).

% ask teacher why i can't use => and =< likes this:
%gen(X, G) :- fighter(X), introIn(X, Y), generation(G, B, T), (Y => B), (Y =< T).

% find generation of jet or find jets by jeneration
gen(X, G) :-
     fighter(X),
      introIn(X, Y),
       generation(G, B, T),
        ((Y > B) ; (Y == B)),
         ((Y < T) ; (Y == T)). 

% find jets by generation of jet of some Role
by_gen_and_role(X, R, G) :- fighter(X), role(X, R), gen(X, G).
