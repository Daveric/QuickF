import { type RootStore } from 'store/RootStore';
import { StoreContext } from 'store/StoreProvider';
import { useContext } from 'react';

export default function useStore(): RootStore {
  return useContext(StoreContext);
}
