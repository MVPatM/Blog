package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//입력을 받는 variable의 name과 query string을 통해 입력되는 data 의 이름이 같아야만 한다.
//변수이름에서 대문자와 소문자는 구분을 하지 않는다.
@RestController
public class HttpControllerTest {

	// 인터넷 브라우저를 통해서 요청을 할 때는 get요청 밖에 할 수없다 다른 요청은 error발생
	//WebAddress -> http://localhost:8080/http/get
	// member variable을 따로따로 받을 수도 있고 아니면 class(member)를 한꺼번에 입력받아서 getter를 이용을 할 수 있다.
	//Spring이 query spring으로 data를 받으면 getTest함수의 parameter m에 data를 알맞게 넣어준다.
	// member class의 member variable을 하나하나 받을 때에는 @RequestParam이라는 annotation을 붙여야 하지만
	// member class를 통채로 입력을 받을 때에는 annotation을 사용을 하지 않는다. 사용을 하면 error가 발생을 한다.
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get request: " + m.getId() + "  and  " + m.getUsername() + " and " + m.getPassword() + " and " + m.getEmail();
	}
	
	//WebAddress -> http://localhost:8080/http/post
	//Post요청은 data를 server에 보낼 때 주소(query string)을 이용을 해서 보내는 것이 아니라 body에 data를 붙여서 보낸다.
	//Body를 통해서 data를 보낼 때 많은 방법이 존재한다.
	// 1. x-www-form-urlencoded방식
	// 이 방식은 html에서 form Tag를 붙여서 input data를 만드는 방식으로 data를 전달은 하는 것이다.
	// Postman을 이용을 해서 data를 server에 보낼 때 그냥 data의 이름과 값을 알맞게 정해서 적어주면 된다.
	// Postman에 실수로 int형 data를 string type으로 적어서 보냈는데 한 번 그렇게 data를 보내니깐 값을 int형으로 바꾸어도 
	// error가 계속 발생이 된다.
	// 2. text파일로 입력을 받는 방식 (/test/plain 파일)
	// body로 data를 받을 때에는 annotation으로 @RequestBody를 사용해야 한다. 이 annotation을 사용을 하지 않으면 정확한 data입력을 받지 못한다.
	// parameter로 string text(string)을 이용을 한다.
	// 3. json파일로 입력을 받는 방식(/application/json 파일)
	// class로 입력을 받아서 getter를 이용을 할 수 있다. 
	// class로 입력을 받더라도 annotation을 사용을 해야 한다.
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post request: " + m.getId() + "  and  " + m.getUsername() + " and " + m.getPassword() + " and " + m.getEmail();
	}
	
	//WebAddress -> http://localhost:8080/http/put
	@PutMapping("/http/put")
	public String putTest() {
		return "put request";
	}
	
	//WebAddress -> http://localhost:8080/http/delete
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete request";
	}
}
