create table public.resume (
                               uuid character(36) primary key not null,
                               full_name text not null
);

create table public.contact (
                                id integer primary key not null,
                                type text not null,
                                value text not null,
                                resume_uuid character(36) not null,
                                foreign key (resume_uuid) references public.resume (uuid)
                                    match simple on update no action on delete cascade
);
create unique index contact_uuid_type_index
    on public.contact (resume_uuid, type);

