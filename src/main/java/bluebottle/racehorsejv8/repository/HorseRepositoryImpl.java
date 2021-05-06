package bluebottle.racehorsejv8.repository;

import bluebottle.racehorsejv8.model.Horse;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class HorseRepositoryImpl implements HorseRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Horse> findAllByTrainerId(Long id) {
        List<String> jpqls = new ArrayList<>();
        jpqls.add("select h from Horse h ");
        jpqls.add("inner join h.accounts a ");
        jpqls.add("inner join Trainer t on t.account = a ");
        jpqls.add("where t.id = :trainerId");
        String jpql = jpqls.stream().reduce("",(current, element) -> current + element);

        TypedQuery<Horse> query = entityManager.createQuery(jpql, Horse.class);
        query.setParameter("trainerId", id);
        return query.getResultList();
    }

    @Override
    public List<Horse> findAllByTrainerIdAndHorseName(Long id, String name, Pageable pageable) {
        List<String> jpqls = new ArrayList<>();
        jpqls.add("select h from Horse h ");
        jpqls.add("inner join h.accounts a ");
        jpqls.add("inner join Trainer t on t.account = a ");
        jpqls.add("where t.id = :trainerId ");
        jpqls.add("and h.name like : horseName");
        String jpql = jpqls.stream().reduce("", (current, element) -> current + element);

        TypedQuery<Horse> query = entityManager.createQuery(jpql, Horse.class);
        query.setParameter("trainerId", id);
        String str = String.format("%%%s%%", name);
        query.setParameter("horseName",str);
        return query.getResultList();
    }
}
