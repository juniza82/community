create table community.users
(
    id                 int auto_increment comment '회원ID' primary key,
    user_id            varchar(100)                 not null comment '사용자ID',
    user_password      varchar(300)                 null comment '비밀번호',
    user_view_password varchar(300)                 null comment '보이는 비밀번호',
    user_prodvider     varchar(100)                 null comment '소셜로그인 공급자 ex)애플, 구글, 네이버, 라인, 카카오',
    user_apple         varchar(100)                 null comment '소셜로그인 애플 ID',
    user_google        varchar(100)                 null comment '소셜로그인 구글 ID',
    user_naver         varchar(100)                 null comment '소셜로그인 네이버 ID',
    user_line          varchar(100)                 null comment '소셜로그인 라인 ID',
    user_kakao         varchar(100)                 null comment '소셜로그인 카카오 ID',
    user_name          varchar(100)                 null comment '사용자 이름',
    user_gender        varchar(1)                   null comment '회원성별',
    user_birthday      varchar(100)                 null comment '사용자 생년월일',
    user_email         varchar(100)                 null comment '사용자 이메일',
    user_tel           varchar(100)                 null comment '사용자 전화',
    user_phone         varchar(100)                 null comment '사용자 핸드폰',
    user_phone_check   varchar(1)                   null comment '핸드폰 인증 유무',
    user_grade         varchar(15)                  null comment '사용자 등급',
    user_agent         varchar(100)                 null comment '핸드폰 기기',
    user_version       varchar(100)                 null comment '앱 버전',
    user_authenticated varchar(1) default 'N'       null comment '로그인 가능 유무 토큰유효여부',
    user_status        varchar(10)                  null comment '회원 상태 ex) 활성, 휴먼, 탈퇴? 이게 왜 있어야 하지?',
    deleted_date       datetime                     null comment '사용자 탈퇴 날짜',
    deleted_flag       varchar(1) default 'N'       null comment '사용자 탈퇴여부',
    created_date       datetime   default sysdate() null comment '등록일',
    created_id         varchar(15)                  not null comment '등록자ID',
    modified_date      datetime                     null comment '수정일',
    modified_id        varchar(15)                  null comment '수정자ID',
    constraint users_pk unique (user_id)
)
    comment '회원';

create table community.user_login_history
(
    id             int auto_increment comment 'ID' primary key,
    user_prodvider varchar(255)               null comment '소셜로그인 공급자 ex)구글, 네이버, 카카오, 애플',
    user_id        varchar(100)               not null comment '사용자ID',
    user_email     varchar(100)               null comment '사용자 이메일',
    user_client_id varchar(100)               null comment '핸드폰 기기',
    user_version   varchar(100)               null comment '앱 버전',
    created_date   datetime default sysdate() null comment '등록일',
    created_id     varchar(15)                not null comment '등록자ID',
    constraint user_login_history_users_user_id_fk foreign key (user_id) references community.users (user_id)
) comment '회원 로그인 히스토리';


create table community.company_terms
(
    id                    int auto_increment comment 'ID' primary key,
    terms_id              int                         null comment '약관ID',
    terms_name            varchar(255)                null comment '약관명',
    terms_version         varchar(255)                null comment '약관버전',
    terms_desc            varchar(255)                null comment '약관정렬',
    terms_content         varchar(255)                null comment '약관내용',
    terms_status          varchar(255)                null comment '약관상태',
    terms_effective_date  timestamp                   null comment '약관활성화날짜',
    terms_expiration_date timestamp                   null comment '약관종료날짜',
    CREATED_DATE          timestamp default sysdate() null comment '등록일',
    CREATED_ID            varchar(255)                not null comment '등록자ID'
) comment '회원';

create table community.files
(
    file_id         int auto_increment comment 'ID' primary key,
    board_id        int          default 0         not null comment '게시판의 PK',
    board_post_id   int          default 0         not null comment '게시물의 PK',
    file_originname varchar(255) default ''        not null comment '파일 업로드시 원래 파일명',
    file_filename   varchar(255) default ''        not null comment '파일 업로드시 서버에 저장된 파일명',
    file_download   int          default 0         not null comment '다운로드 회수',
    file_filesize   int          default 0         not null comment '파일 크기',
    file_type       varchar(10)  default ''        not null comment '파일 확장자',
    file_is_image   tinyint      default 0         not null comment '이미지인지 여부',
    file_width      mediumint(6) default 0         not null comment '이미지일 경우 이미지 가로값',
    file_height     mediumint(6) default 0         not null comment '이미지일 경우 이미지 세로값',
    user_ip         varchar(50)  default ''        not null comment '등록 IP',
    deleted_date    datetime                       null comment '삭제 날짜',
    deleted_flag    varchar(1) default 'N'         null comment '삭제 여부',
    created_date    datetime     default sysdate() null comment '등록일',
    created_id      varchar(15)                    null comment '등록자ID'
) comment '파일 ';

create table community.file_download_log
(
    id           int auto_increment comment 'ID' primary key,
    file_id      int          default 0         not null comment '첨부파일 테이블 (file table) 의 PK',
    post_id      int          default 0         not null comment '게시물 테이블 (post_table) 의 PK',
    brd_id       int          default 0         not null comment '게시판 테이블 (board table) 의 PK',
    user_id      varchar(255) default ''        null comment '다운로드한 유저의 user agent',
    user_ip      varchar(50)  default ''        null comment '다운로드 IP',
    user_agent   varchar(255) default ''        null comment '다운로드한 유저의 user agent',
    created_date datetime     default sysdate() null comment '등록일',
    created_id   varchar(15)                    not null comment '등록자ID',
    constraint file_download_log_files_file_id_fk foreign key (user_id) references community.users (user_id)
) comment '파일 다운로드 로그';

create table community.company_bbs
(
    id            int auto_increment primary key comment 'ID',
    company_type  varchar(30)                null comment '게시판구분',
    title         varchar(1000)              not null comment '제목',
    content       text                       not null comment '내용',
    view_count    int                        null comment '글확인수',
    ordering      int                        null comment '정렬순서',
    deleted_date  datetime                   null comment '사용자 탈퇴 날짜',
    deleted_flag  varchar(1) default 'N'     null comment '삭제여부',
    created_date  datetime default sysdate() null comment '등록일',
    created_id    varchar(15)                not null comment '등록자ID',
    modified_date datetime                   null comment '수정일',
    modified_id   varchar(15)                null comment '수정자ID'
) comment '회사게시판 (공지사항, FAQ 등등)'