package guru.springframework.springrestclientexamples.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import guru.springframework.api.domain.User;

@Service
public class ApiServiceImpl implements  ApiService {

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        User[] users = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/users?_limit=" + limit, User[].class).getBody();

        return Arrays.stream(users).collect(Collectors.toList());
    }
}
