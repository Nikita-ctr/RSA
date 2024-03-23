### Bacis RSA algorithm

The RSA class represents an RSA encryption scheme. It generates the public and private keys based on a given bit length N in the constructor.
Random variable is a SecureRandom object used for generating random prime numbers.
* The privateKey, publicKey, and modulus variables store the generated RSA keys.
* The encrypt method takes a BigInteger message and encrypts it using the public key and modulus.
* The decrypt method takes a BigInteger encrypted message and decrypts it using the private key and modulus.
