package b.b.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/b")
public class AppControler {

	@GetMapping(path = "/c")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getHello() {
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body("Hello !");
	}

	@GetMapping(path = "/{username}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getHello(@PathVariable String username) {
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body("Hello " + username + " !");
	}
	
	@GetMapping(path = "/d")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getGoodbye(@RequestParam(required = false) String username) {
		return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body("Bye " + username + " !");
	}
}
