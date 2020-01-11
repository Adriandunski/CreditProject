# CreditProject
Uruchomienie całej aplikacji odbywa się przez plik docker-compose.yml. W oknie programu Power Shell (w wybranym foderze gdzie znajduje sięplik) wpisać komende:

$ docker-compose up 

W folderach są już przygotowane pliki JAR, więc nie trzeba nawet pakować tego samemu. Wszystko już jest gotowe i przygotowane do wystartowania. (Można usunąć w razie czego i spakować aplikacje samemu)

Przy pierwszej inicializacji czy uruchomieniu komendy, do bazy danych zostanie wprowadzony 5 przykładowych kredytów. 



Poszczególne komponenty aplikacji uruchamiają sięna tych portach.

SpringBoot Credit - 8080
SpringBoot Product - 8081
SpringBoot Customer - 8082
Baza Danych - 3306

Do sprawdzenia usług wystarczy wpisać więc w przeglądarke:

Do usługi getCredits - http://localhost:8080/getCredits
Do usługi creatCredit - http://localhost:8080/creatCredit

By korzystać z samego Api przez Aplikacje np. Postman są to takie adresy

Do usługi getCredits - http://localhost:8080/getCreditsApi
Do usługi creatCredit - http://localhost:8080/creatCreditApi

Lecz gdy będziemy chcieli wysyłać żadanie stworzenia kredytu proszę trzymać się tych zmiennych.

Wszystkie zmienne muszą być uzupełnione w innym razie nie będzie możliwe wprowadzenia danych do baz.
Zakładam że pesel składa się tylko z cyfr, musi mieć 11 oraz nie możę się powtórzyć w bazie.
W prodcutValue wartość musi być wieksza lub równa 1. 

{
	"customerName": "Klaudia",
	"customerLast": "Murańska",
	"customerPesel": "97512563333",
	"productName": "product99",
	"productValue": 5000,
	"creditName": "credit653"
}
