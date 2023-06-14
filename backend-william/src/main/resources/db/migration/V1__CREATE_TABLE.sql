create table robot_log (
	robot_id integer,
	production_line_id integer,
	machine_id integer,
	"timestamp" Timestamp,
	software text,
	severity text,
	"message" text,

	constraint pk_logId primary key ("timestamp", software, "message")
);