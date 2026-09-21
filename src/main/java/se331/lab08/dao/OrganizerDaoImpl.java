package se331.lab08.dao;

import org.springframework.stereotype.Repository;
import se331.lab08.entity.Organizer;
import org.springframework.context.annotation.Profile;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("memory")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .organizationName("Kat Laydee Animal Rescue")
                .address("12 Meow Town Road, Meow Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(2L)
                .organizationName("Fern Pollin Community Gardens")
                .address("45 Flora City Avenue, Flora City")
                .build());
        organizerList.add(Organizer.builder()
                .id(3L)
                .organizationName("Carey Wales Ocean Trust")
                .address("8 Playa Del Carmen Boulevard, Playa Del Carmen")
                .build());
        organizerList.add(Organizer.builder()
                .id(4L)
                .organizationName("Dawg Dahd Rescue Center")
                .address("21 Woof Town Lane, Woof Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(5L)
                .organizationName("Kahn Opiner Food Bank")
                .address("100 Tin City Street, Tin City")
                .build());
        organizerList.add(Organizer.builder()
                .id(6L)
                .organizationName("Brody Kill Highway Alliance")
                .address("Mile 50, Highway 50")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex, Math.min(firstIndex + pageSize, organizerList.size()));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size() - 1).getId() + 1);
        organizerList.add(organizer);
        return organizer;
    }
}