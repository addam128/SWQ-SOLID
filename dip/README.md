# Dependency inversion

Violations:
* main depends on specific details of the used recommendation services
* recommendation services depend on the specifics of the particular forecast service
* recommendation services depend on the specifics of the particular forecast response

Solving the problem:

* Recommendation services must respect a contract, main uses this contract to communicate
* Forecast services must respect a contract, recommendation services use this
* Forecast responses must respect a contract, recommendation services use this
* __Note:__ under contract I mean a set of functionalities that must be provided, respectively required by callers

Benefits:
* Easy scalability (adding new services (recommendation, forecast))
* cleaner code
* somewhat enforces single responsibility principle
* code gets easier to read, as we only need to study those contracts
