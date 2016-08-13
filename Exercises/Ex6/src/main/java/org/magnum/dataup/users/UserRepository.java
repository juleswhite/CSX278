package org.magnum.dataup.users;

import org.magnum.dataup.VideoSvcApi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = VideoSvcApi.VIDEO_SVC_PATH)
public interface UserRepository extends CrudRepository<User, Long>{

}