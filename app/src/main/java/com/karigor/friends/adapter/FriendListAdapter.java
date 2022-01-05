//package com.karigor.friends.adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Filter;
//import android.widget.Filterable;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//public class FriendListAdapter extends RecyclerView.Adapter<PackageListAdapter.MyViewHolder>
//
//implements Filterable {
//
//
//private Context context;
//private List<Package> packages;
//    private List<Package> packagesFull;
//
//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                List<Package> filteredList = new ArrayList<>();
//                if (constraint == null || constraint.length() == 0) {
//                    filteredList.addAll(packagesFull);
//                } else {
//                    String filterPattern = constraint.toString().toLowerCase().trim();
//                    for (Package item : packagesFull) {
//
//                        if (item.getUnionName().toUpperCase(Locale.ROOT).contains(filterPattern.toUpperCase(Locale.ROOT))) {
//                            filteredList.add(item);
//                            continue;
//                        }
//                        if (item.getDistrictName().contains(filterPattern)) {
//                            filteredList.add(item);
//                            continue;
//                        }
//                        if (item.getUpazilaName().contains(filterPattern)) {
//                            filteredList.add(item);
//                            continue;
//                        }
//                        if (item.getDivisionName().contains(filterPattern)) {
//                            filteredList.add(item);
//                            continue;
//                        }
//                    }
//                }
//                FilterResults results = new FilterResults();
//                results.values = filteredList;
//                return results;
//            }
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                packages.clear();
//                packages.addAll((List) results.values);
//                notifyDataSetChanged();
//            }
//        };
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//    public TextView tvPackageNo, tvDistrict,tvUpazila,tvUnion,tvDivision;
//    public MyViewHolder(View view) {
//        super(view);
//
//        tvPackageNo = view.findViewById(R.id.tvPackageNo);
//        tvDistrict = view.findViewById(R.id.tvDistrict);
//        tvUpazila = view.findViewById(R.id.tvUpazila);
//        tvUnion = view.findViewById(R.id.union_text_view);
//        tvDivision = view.findViewById(R.id.division_text_view);
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                context.startActivity(new Intent(context, SchemaListActivity.class)
//                        .putExtra("Package",packages.get(getAdapterPosition())));
//
//            }
//        });
//
//    }
//
//}
//
//    public FriendListAdapter(Context context, List<Package> packages) {
//        this.context = context;
//        this.packages = packages;
//        this.packagesFull = new ArrayList<>(packages);
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.package_list_item, parent, false);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(final MyViewHolder holder, final int position) {
//        Package packageTulo = packages.get(position);
//        holder.tvPackageNo.setText(packageTulo.getPackageNo());
//
//        holder.tvDistrict.setText("District : "+ packageTulo.getDistrictName());
//        holder.tvUpazila.setText("Upazila : "+  packageTulo.getUpazilaName());
//        holder.tvUnion.setText("Union : "+  packageTulo.getUnionName());
//        holder.tvDivision.setText("Division : "+ packageTulo.getDivisionName());
//    }
//
//    public void updateList(List<Package> list){
//        this.packages = list;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public int getItemCount() {
//        return packages.size();
//    }
//}
//
