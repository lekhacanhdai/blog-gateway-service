set search_path to appconfig;

insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('gateway-service', 'default', 'master', 'blog.grpc.client.account.message.size', '25', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('gateway-service', 'default', 'master', 'blog.grpc.client.account.host', 'account-service', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('gateway-service', 'default', 'master', 'blog.grpc.client.account.port', '8102', null, now(), now());
