create function get_data_cust(data_cust character varying)
    returns TABLE(id character varying, username character varying, email character varying, fullname character varying, mobile_no character varying, no_acct character varying, atm_cif_no character varying, visa_master_cif_no character varying, balance character varying)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY select a.id,a.username,b.email,b.full_name,b.mobile_no,d.no_acct,a.atm_cif_no,a.visa_master_cif_no,cast(d.balance as varchar)
                 from danamon.tbl_cust a
                          inner join danamon.tbl_cust_profile b
                                     on b.cust_id = a.id
                          inner join danamon.tbl_cust_rel c
                                     on c.cust_id = a.id
                          inner join danamon.tbl_acct d
                                     on d.id = c.acct_id
                 where a.username = data_cust;
END;
$$;

alter function get_data_cust(varchar) owner to postgres;

