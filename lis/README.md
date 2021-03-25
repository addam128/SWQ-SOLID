# Liskov Substitution
Interface violations:

* CSVSerializer cannot handle arrays of strings even when required
* CSVSerializer is not stateles, which might lead to concurrency issues, this is also prohibited by the interface
* CompressingSerializer does not respect the requirement on symmetric functionality