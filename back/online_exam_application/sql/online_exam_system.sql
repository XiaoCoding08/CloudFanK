/*==============================================================*/
/* DBMS name:      MySQL 8.0                                    */
/* Created on:     2023/12/19 0:05:31                           */
/*==============================================================*/

drop Database if exists online_exam_application;

/*==============================================================*/
/* Database: online_exam_application                            */
/*==============================================================*/
create Database  online_exam_application;

use online_exam_application;

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
    id                   bigint not null        COMMENT '班级号',
    name                 char(20) not null      COMMENT '班级名',
    course_id            bigint not null        COMMENT '关联课程号',
    create_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete            tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="班级表";

/*==============================================================*/
/* Table: class_exam                                            */
/*==============================================================*/
create table class_exam
(
    class_id               bigint not null      COMMENT '班级号',
    exam_id                bigint not null      COMMENT '考试号',
    create_time            datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time            datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete              tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (class_id, exam_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="班级考试表";

/*==============================================================*/
/* Table: class_student                                         */
/*==============================================================*/
create table class_student
(
    class_id               bigint not null      COMMENT '班级号',
    student_id             bigint not null      COMMENT '学生学号',
    create_time            datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time            datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete              tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (class_id, student_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="班级学生表";

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
    id                   bigint not null        COMMENT '课程号',
    name                 char(20) not null      COMMENT '课程名',
    create_user          bigint not null        COMMENT '教师工号',
    create_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete            tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="课程表";

/*==============================================================*/
/* Table: exam                                                  */
/*==============================================================*/
create table exam
(
    id                   bigint not null        COMMENT '考试号',
    start_time           datetime not null      COMMENT '开始时间',
    end_time             datetime not null      COMMENT '结束时间',
    create_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete            tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="考试表";

/*==============================================================*/
/* Table: exam_question                                         */
/*==============================================================*/
create table exam_question
(
    question_id               bigint not null   COMMENT '题号',
    exam_id                   bigint not null   COMMENT '考试号',
    indexs                    int not null      COMMENT '题序',
    scores                    int               COMMENT '分数',
    create_time               datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time               datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete                 tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (question_id, exam_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="考试题目表";

/*==============================================================*/
/* Table: question                                              */
/*==============================================================*/
create table question
(
    id                   bigint not null        COMMENT '题号',
    course_id            bigint not null        COMMENT '课程号',
    type                 tinyint not null       COMMENT '题型',
    context              longtext not null      COMMENT '内容',
    image_url            longtext               COMMENT '图片地址',
    answer               longtext               COMMENT '答案',
    create_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete            tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="题目表";

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
    id                   bigint not null        COMMENT '学号',
    name                 char(20) not null      COMMENT '姓名',
    password             char(20) not null      COMMENT '密码',
    create_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete            tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="学生表";

/*==============================================================*/
/* Table: student_answer                                        */
/*==============================================================*/
create table exam_student
(
    exam_id               bigint not null       COMMENT '考试号',
    student_id            bigint not null       COMMENT '学生学号',
    answer                longtext              COMMENT '答题记录',
    create_time           datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time           datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete             tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (exam_id, student_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="考试参与表";

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
    id                   bigint not null        COMMENT '工号',
    name                 char(20) not null      COMMENT '姓名',
    password             char(20) not null      COMMENT '密码',
    create_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time          datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    is_delete            tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0 - 未删除，1 - 删除）',
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT="教师表";


