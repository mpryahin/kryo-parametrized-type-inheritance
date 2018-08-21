This test reproduces an issue with parameterized type hierarchy[1,2].
Use kryoVersion to run against different kryo versions:
 
-PkryoVersion=3.0.3 to reproduce the issue

    ./gradlew run -PkryoVersion=3.0.3
    
-PkryoVersion=4.0.0 to make sure the issue has been fixed.

    ./gradlew run -PkryoVersion=4.0.0

[1] https://github.com/EsotericSoftware/kryo/issues/384
[2] https://github.com/EsotericSoftware/kryo/issues/377
