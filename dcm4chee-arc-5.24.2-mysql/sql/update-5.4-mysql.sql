create table mwl_item (
    pk bigint not null auto_increment,
    accession_no varchar(255) not null,
    created_time datetime not null,
    modality varchar(255) not null,
    req_proc_id varchar(255) not null,
    sps_id varchar(255) not null,
    sps_start_date varchar(255) not null,
    sps_start_time varchar(255) not null,
    sps_status integer not null,
    study_iuid varchar(255) not null,
    updated_time datetime not null,
    version bigint,
    dicomattrs_fk bigint not null,
    accno_issuer_fk bigint,
    patient_fk bigint not null,
    perf_phys_name_fk bigint,
    primary key (pk));

create table sps_station_aet (
    pk bigint not null auto_increment,
    station_aet varchar(255) not null,
    mwl_item_fk bigint not null,
    primary key (pk));

alter table mwl_item add constraint UK_6qj8tkh6ib9w2pjqwvqe23ko  unique (dicomattrs_fk);
alter table mwl_item add constraint UK_lerlqlaghhcs0oaj5irux4qig  unique (study_iuid, sps_id);
create index UK_d0v5hjn1crha2nqbws4wj0yoj on mwl_item (updated_time);
create index UK_2odo3oah39o400thy9bf0rgv0 on mwl_item (sps_id);
create index UK_kedi0qimmvs83af3jxk471uxn on mwl_item (req_proc_id);
create index UK_fpfq8q514gsime2dl8oo773d4 on mwl_item (study_iuid);
create index UK_pw8h1b4sac2sr9estyqr82pcf on mwl_item (accession_no);
create index UK_q28149iaxebyt3de2h5sm2bgl on mwl_item (modality);
create index UK_9oh3yd4prp9sfys4n0p2kd69y on mwl_item (sps_start_date);
create index UK_m20xnkg1iqetifvuegehbhekm on mwl_item (sps_start_time);
create index UK_3oigo76r1a7et491bkci96km8 on mwl_item (sps_status);
create index UK_tm93u8kuxnasoguns5asgdx4a on sps_station_aet (station_aet);
alter table mwl_item add constraint FK_6qj8tkh6ib9w2pjqwvqe23ko foreign key (dicomattrs_fk) references dicomattrs (pk);
alter table mwl_item add constraint FK_ot32lpvialton54xqh636c4it foreign key (accno_issuer_fk) references issuer (pk);
alter table mwl_item add constraint FK_vkxtls2wr17wgxnxj7b2fe32 foreign key (patient_fk) references patient (pk);
alter table mwl_item add constraint FK_44qwwvs50lgpog2cqmicxgt1f foreign key (perf_phys_name_fk) references person_name (pk);
alter table sps_station_aet add constraint FK_js5xqyw5qa9rpttwmck14duow foreign key (mwl_item_fk) references mwl_item (pk);