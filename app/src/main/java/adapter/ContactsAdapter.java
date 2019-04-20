package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.recyclerview.DetailsActivity;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Contacts;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> implements Filterable {

    Context mContext;
    List<Contacts> contactsList;
    List<Contacts> contactsListFull;


    public ContactsAdapter(Context mContext, List<Contacts> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
        contactsListFull= new ArrayList<>(contactsList);
    }


    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact,viewGroup,false);

        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder contactsViewHolder, int i) {
        final Contacts contacts = contactsList.get(i);
        contactsViewHolder.imgProfile.setImageResource(contacts.getImageId());
        contactsViewHolder.tvName.setText(contacts.getName());
        contactsViewHolder.tvPhone.setText(contacts.getPhoneNo());



        contactsViewHolder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);

                intent.putExtra("image", contacts.getImageId());
                intent.putExtra("name", contacts.getName());
                intent.putExtra("phone", contacts.getPhoneNo());
                intent.putExtra("email",contacts.getEmail());
                intent.putExtra("address",contacts.getAddress());
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Contacts> filteredList = new ArrayList<>();
            if (constraint==null || constraint.length()==0){
                filteredList.addAll(contactsListFull);
            }
            else {
                String filterpattern= constraint.toString().toLowerCase().trim();

                for (Contacts item : contactsListFull){
                    if(item.getName().toLowerCase().contains(filterpattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results= new FilterResults();
            results.values= filteredList;

            return results;

             }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            contactsList.clear();
            contactsList.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };

    public class ContactsViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgProfile;
        TextView tvName, tvPhone;


        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile= itemView.findViewById(R.id.imgProfile);
            tvName= itemView.findViewById(R.id.tvName);
            tvPhone= itemView.findViewById(R.id.tvPhone);

            }
    }
}
