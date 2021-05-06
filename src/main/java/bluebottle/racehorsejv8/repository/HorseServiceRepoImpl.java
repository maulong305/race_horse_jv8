package bluebottle.racehorsejv8.repository;

import bluebottle.racehorsejv8.model.Horse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class HorseServiceRepoImpl implements HorseRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Horse> findAllByTrainerId(Long id) {
        List<String> jpqls = new ArrayList<>();
        jpqls.add("SELECT * FROM Horse");
//        jpqls.add("select h from Horse h ");
//        jpqls.add("inner join h.accounts a ");
//        jpqls.add("inner join Trainer t on t.account = a ");
//        jpqls.add("where t.id = 3");
        String jpql = jpqls.stream().reduce("",(current, element) -> current + element);

        TypedQuery<Horse> query = entityManager.createQuery(jpql, Horse.class);
//        query.setParameter("trainerId", id);
        return query.getResultList();
    }
}
