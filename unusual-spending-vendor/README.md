# unusual-spending-vendor

**Do not change the code in this project! It's only here to support the
[unusual-spending](../unusual-spending) project.**

Unlike the other projects in this set of examples, this project is designed to
act like a dependency would—suppose that it's owned by another team or
department.

In any case, part of the challenge in the [Unusual Spending
Kata](https://github.com/testdouble/contributing-tests/wiki/Unusual-Spending-Kata)
is to make forward progress designing a bit of code when the contract between
ourselves and our dependencies are well-defined, but the dependencies themselves
are out of our control.

In this case, the kata will depend on `spending.EmailsUser` and
`spending.FetchesUserPaymentsByMonth`. Both of these have yet to be implemented,
would be difficult to mock even if they were, and cannot be changed (as a rule
of the kata).

```
.
├── src
│   ├── main
│   │   └── java
│   │       └── spending
│   │           ├── EmailsUser.java
│   │           └── FetchesUserPaymentsByMonth.java
```
