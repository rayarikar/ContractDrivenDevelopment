import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url "/person/${regex('^[A-Za-z0-9]+$')}"
        headers {
            header 'Content-Type': 'application/json'
        }
    }
    response {
        status 200
        body '''
                    {
                        "personId": "p123",
                        "firstName": "Harry",
                        "lastName": "Potter",
                        "address": {
                            "line": "123 Hogwarts Castle",
                            "city": "Hogwarts",
                            "state": "HG",
                            "zipCode": "hp123",
                            "country": "UK"
                        }
                    }
            '''
    }
}