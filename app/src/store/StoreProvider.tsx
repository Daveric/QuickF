import { createContext, type ReactNode } from 'react';
import { RootStore } from './RootStore';
import { useLocalObservable } from 'mobx-react-lite';

export const StoreContext = createContext<RootStore>(new RootStore());

export class StoreProvideProps {
  children: ReactNode;
}

const StoreProvider = ({ children }: StoreProvideProps): JSX.Element => {
  const store = useLocalObservable(() => new RootStore());
  return (
    <StoreContext.Provider value={store}>{children}</StoreContext.Provider>
  );
};

export default StoreProvider;
