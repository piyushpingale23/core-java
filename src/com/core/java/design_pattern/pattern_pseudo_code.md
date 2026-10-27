# 1. CREATIONAL:

## 1.1 Singleton

```java
class Singleton {
	private final Singleton instance;
	Singleton(Singleton instance) {
		this.instance = instance;
	}

	public static Singleton getInstance() {
		if (instance == null) {
			return new Singleton();
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2); // true
	}
}
```

---

## 1.2 Builder

```java
@Setter
@Getter
@Builder
class Order {
	int id;
	String name;
	String location;
	String mobile;
}

public class Main {
	public static void main(String[] args) {
		Order o = Order.builder()
			.name("a")
			.location("b")
			.build();
	}
}
```
---

## 1.3 Factory

```java
interface Payment {
	void pay();
}

class UpiPayment implements Payment {
	// UpiPayment pay() implementation
}

class CardPayment implements Payment {
	// CardPayment pay() implementation
}

class PaymentFactory {

    public static Payment makePayment(String mode) {
        return switch (mode.toLowerCase()) {
            case "upi" -> new UpiPayment();
            case "card" -> new CardPayment();
            default -> throw new IllegalArgumentException("Unsupported payment mode: " + mode);
        };
    }
}

class Main {
	public static void main(String[] args) {
		Payment payment = PaymentFactory.makePayment("upi");
		payment.pay();
	}
}
```
---

# 2. STRUCTURAL

## 2.1 Adapter

```java
interface Payment {
    void pay();
}

class UpiPayment {
    void makeUpiPayment() { }
}

class PaymentAdapter implements Payment {
    private final UpiPayment upiPayment;
    PaymentAdapter(UpiPayment upiPayment) {
        this.upiPayment = upiPayment;
    }

    @Override
    public void pay() {
        upiPayment.makeUpiPayment();
    }
}

public class Main {
    public static void main(String[] args) {
        Payment payment = new PaymentAdapter(new UpiPayment());
        payment.pay();
    }
}
```

---

# 3. BEHAVIOURAL

## 3.1 Strategy

```java
interface Payment {
	void pay();
}

class UpiPayment implements Payment {
	// UpiPayment pay() implementation
}

class CardPayment implements Payment {
	// CardPayment pay() implementation
}

class PaymentStrategy {
    private Payment payment;
    PaymentStrategy (Payment payment) {
        this.payment = payment;
    }

    public void makePayment() {
        payment.pay();
    }
}

class Main {
    public static void main(String[] args) {
        PaymentStrategy strategy = new PaymentStrategy(new UpiPayment());
        strategy.makePayment();
    }
}
```