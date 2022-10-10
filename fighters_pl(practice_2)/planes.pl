
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

devFrom(f15EStrikeEagle, test).
devFrom(f15J, test).

devFrom(f16XL,f16FightingFalcon).
devFrom(f2, f16FightingFalcon).

devFrom(f35LightningII,x35JSF).

devFrom(spiteful, spitfire).
devFrom(seafang, spitfire).
devFrom(attacker, spiteful).
devFrom(swift, attacker).
devFrom(supermarine545, swift).

generation(first, 1940, 1950).
generation(second, 1955, 1960).
generation(third, 1960, 1970).
generation(fourth, 1970, 1985).
generation(fifth, 1990, 2000).
generation(sixth, 2000, 2029).

%find variation of aircraft(jet)
varOf(X,Y) :- devFrom(X,Z), devFrom(Y,Z), not(Y == X).

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
origin(X, X) :- not(devFrom(X, Z)), fighter(Z), !. % rewind
origin(X, R) :- devFrom(X, Y), origin(Y, R).

%find last modifications of fighter jet
lastMod(X, X) :- not(devFrom(Z, X)), fighter(Z), !. % rewind
lastMod(X, R) :- devFrom(Y, X), lastMod(Y, R).

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
byGenAndRole(X, R, G) :- fighter(X), role(X, R), gen(X, G).
