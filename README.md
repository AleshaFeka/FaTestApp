The project architecture complies with Google recommendations - division into UI/Domain/Data layers. 
ViewModel is used as a state holder, UI implementation is implemented using Jetpack Compose, and the network client is Apollo GraphQL. 
Due to insufficient time, caching was not implemented, and a stub was used instead of a real DI.
For the same reason, unit tests were not implemented, which can be corrected at any time later if time permits.
