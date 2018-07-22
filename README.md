# Java-Digital-Signature
Java command line  tool for digital signature

NOTA: only ***PAdES*** format

```bash
#help
java -jar signer.jar -h

Usage:PKCS#11 Digital Signature Tool
  Options:
    -c, --cades
      CAdES sign format
    -p, --pades
      PAdES sign format
    -d, --driver
      PKCS#11 Driver
    -h, --help 
    
```

#### Basic Usage:
```bash
#use default driver and use CAdES sign format
java -jar signer.jar filetosign.pdf

#use a custom driver
java -jar signer filetosign.pdf -d customdriver

#setting sign format with option
-p: PAdES
-c: CAdES

java -jar signer.jar test.pdf -p 
java -jar signer.jar test.txt -c 
```
