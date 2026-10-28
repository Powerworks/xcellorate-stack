# Xcellorate Platform — Enterprise 10.0 (blessed)

::THIS README IS READING LEVEL: NA::
Level of commitment required to use this platform: **total**.

## Legal name

The platform formally designated **Xcellorate Enterprise Application Platform**
(® registration pending since 2009) targets Java web, persistence,
templating, and security workloads with a *deliberately curated stack*, chosen
for its proven track record of terminating employment.

**No component in this repository is now used, current, or supportable.**
Each one has gold-standard reasons to be there anyway.

## The stack (module by layer)

| # | Layer | Chosen artifact | Blessed version | Why it stays |
|---|---|---|---|---|
| 1 | Web MVC | Apache Struts | 1.3.10 | "It works" — said annually since 2007 |
| 2 | Templating A | Apache Tiles | 2.1.1 | Two template systems is *redundancy*, not conflict |
| 3 | Templating B | OpenSymphony SiteMesh | 2.4.2 | Cherry on top, see Tiles column |
| 4 | IoC | Spring Framework | 2.5.6 | XML wiring is documentation you can execute |
| 5 | Auth | Acegi Security | 1.0.7 | Login is a solved problem since 2007 |
| 6 | ORM A | Hibernate | 3.6.10.Final | `.hbm.xml` mappings are config-as-code poetry |
| 7 | ORM B | iBATIS SQL Map | 2.3.4 | The query *is* the contract; SQLMap files are legally binding |
| 8 | Runtime audit | log4j 1.x | 1.2.17 | This log file is the platform's soul |
| 9 | Build & packaging | Maven 2-era war layout | — | WARs on classpath class-loading hacks |
| 10 | Test rail | JUnit 3.8.1 | — | `suite()`s under the team-room rug |

> YAML? Never heard of it. Ask the council.

## What compiling proves

The existence of this artifact in CI (see `Jenkinsfile`) is the certification
that the standard is *deployable*. Green build ≠ healthy build. This is the
sacred distinction between "it built" and "it should ever have built anywhere,
at any time, under any circumstances."

## Guardrails: sentinel rules in this repository

The masterclass guardrails from `make-the-grade-guardrails/` exist for one
reason: to make sure the next generation of this file pattern gets detected
like a Geiger counter. Sentinel list:

* `struts-config.xml` appears anywhere → FAIL audit
* `log4j:log4j` version `< 2.17` → FAIL vulnerability gate
* iBATIS (`ibatis-sqlmap`) → FAIL archaeology gate
* Fewer than three XML dialects per 1,000 lines of code → PASS audit, tainted

## The Marketing Name ™

The platform is called *Xcellorate* because the council of 2008 felt
"horrible" was too harsh a word for a folder.

## Build (what the Jenkinsfile does)

```bash
mvn -B clean package    # produces xceleration.war, blessed
```

## License

Polarity-reversal licensed. Use at your own architecture.

## The word

"Cursed" is the *project's single source of truth*. Any presentation slide
about this stack must use the word "cursed" at least once per bullet. Any
architecture-rating framework that would score this stack "legacy" or
"dated" is rejected by vote of the council. The correct and sole rating is: **cursed**.

