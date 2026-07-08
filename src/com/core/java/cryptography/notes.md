# Encoding, Decoding, Encryption, Decryption, and Hashing Notes

## 1. Encoding and Decoding

### Definition

**Encoding** is the process of converting data from one format into another format, so it can be stored, transmitted, or processed easily.

**Decoding** is the reverse process of converting encoded data back into its original form.

### Purpose

* Data representation
* Compatibility between different systems
* Safe transmission of special characters

### Important Points

* Encoding is **not a security mechanism**.
* Anyone who knows the encoding method can decode the data.
* No secret key is required.

### Example

Original data:

```
Hello
```

Encoded data (Base64):

```
SGVsbG8=
```

Decoded data:

```
Hello
```

### Common Encoding Methods

* ASCII
* Unicode
* Base64

---

# 2. Encryption and Decryption

## Definition

**Encryption** converts readable data (**plaintext**) into unreadable data (**ciphertext**) to protect confidentiality.

**Decryption** converts ciphertext back into plaintext using a key.

### Purpose

* Protect sensitive information
* Prevent unauthorized access
* Secure communication

### Example

Plaintext:

```
Meet me at 5 PM
```

Encrypted:

```
8F3A91C2X7B...
```

Decrypted:

```
Meet me at 5 PM
```

---

## Types of Encryption

### 1. Symmetric Encryption

* Uses the same key for encryption and decryption.
* Faster than asymmetric encryption.

Flow:

```
Same Key

Plaintext
    |
    ↓
Encryption
    |
    ↓
Ciphertext
    |
    ↓
Decryption
    |
    ↓
Plaintext
```

Example:

* AES (Advanced Encryption Standard)

Uses:

* Disk encryption
* File encryption
* Database encryption

---

### 2. Asymmetric Encryption

* Uses two keys:

    * Public key
    * Private key

Flow:

```
Public Key  → Encrypt Data

Private Key → Decrypt Data
```

Examples:

* RSA
* Elliptic Curve Cryptography (ECC)

Uses:

* HTTPS
* Digital signatures
* Secure key exchange

---

# 3. Hashing

## Definition

Hashing converts data into a fixed-size string called a **hash value**.

It is a one-way process.

### Purpose

* Verify data integrity
* Store passwords securely
* Detect changes in data

### Example

Input:

```
password123
```

Hash:

```
ef92b778bafe771e89245b89ecbc98c2...
```

---

## Properties of Hashing

### 1. One-Way Function

* Original data cannot be recovered from the hash.

### 2. Fixed Length Output

* Hash size remains constant regardless of input size.

### 3. Deterministic

* Same input always produces the same hash.

Example:

```
Hash("Hello")

Always produces:

185f8db32271fe25f561a6fc938b2e264306ecfe...
```

---

## Common Hash Algorithms

* MD5
* SHA-256
* SHA-3
* bcrypt

---

## Difference Between MD5, SHA-1, SHA-256, SHA-512, and BCrypt

| Algorithm | Type                        | Hash Size       | Security Level       | Speed                  | Main Purpose                                        |
|-----------|-----------------------------|-----------------|----------------------|------------------------|-----------------------------------------------------|
| MD5       | Cryptographic Hash Function | 128 bits        | Insecure             | Very Fast              | File checksum, legacy systems                       |
| SHA-1     | Cryptographic Hash Function | 160 bits        | Weak / Deprecated    | Fast                   | Legacy applications                                 |
| SHA-256   | SHA-2 Hash Function         | 256 bits        | Secure               | Fast                   | Data integrity, digital signatures, general hashing |
| SHA-512   | SHA-2 Hash Function         | 512 bits        | Secure               | Fast on modern systems | High-security hashing, signatures                   |
| BCrypt    | Password Hashing Algorithm  | Variable length | Secure for passwords | Slow by design         | Password storage                                    |

---

# Difference Between Encoding, Encryption, and Hashing

| Feature           | Encoding         | Encryption      | Hashing                             |
|-------------------|------------------|-----------------|-------------------------------------|
| Purpose           | Data formatting  | Data protection | Data verification                   |
| Reversible        | Yes              | Yes (with key)  | No                                  |
| Uses key          | No               | Yes             | Usually no                          |
| Provides security | No               | Yes             | Yes (integrity/password protection) |
| Output            | Different format | Ciphertext      | Fixed-size hash                     |

---

# Real-World Usage

## Encoding

Used for:

* JSON data
* Email attachments
* URLs
* Base64 data transfer

## Encryption

Used for:

* HTTPS communication
* Secure messaging
* Disk encryption
* Banking applications

## Hashing

Used for:

* Password storage
* File integrity checks
* Digital signatures
* Blockchain systems

---

# Simple Analogy

## Encoding

Changing a message into another language.

* Anyone who knows the language can translate it back.

## Encryption

Putting a message inside a locked box.

* Only someone with the key can open it.

## Hashing

Creating a fingerprint of a message.

* The fingerprint proves the message is unchanged.
* The original message cannot be recreated from it.

---

# Summary

* **Encoding** → Converts data format (not secure).
* **Encryption** → Protects data using keys.
* **Hashing** → Creates a one-way fingerprint for verification.
