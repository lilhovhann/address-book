package io.project.app.addressbook.repositories;

import io.project.app.addressbook.domain.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author lilit
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
 
}
