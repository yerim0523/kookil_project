package com.web.global.common.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * @MappedSuperclass : 공통 맵핑 정보가 필요할 때 사용하며 부모 클래스에서 선언하고 속성만 상속 받아서 사용하고 싶을 때 사용합니다. BaseEntity 를 상속받는 클래스는 모두 createdAt, createdBy 필드가 있어야 합니다.
 * @EntityListeners(AuditingEntityListener::class) : JPA Entity 에 이벤트가 발생할 관련 코드를 실행합니다.
 * @CreatedDate : 생성 일자를 관리하는 필드에 현재 날짜를 주입하는 작업을 수행합니다. 
 * @Column(updatable = false) : 생성일자, 생성자에 대한 필드이기 때문에 수정 불가하도록 설정합니다.
 * */

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
